package org.hotilsframework.core.logging;

import org.hotilsframework.core.collection.Lists;
import org.hotilsframework.core.collection.Maps;
import org.hotilsframework.core.logging.layout.Layout;
import org.hotilsframework.utils.ReflectionUtils;
import org.hotilsframework.utils.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * XML配置器
 * @author hireny
 * @className XMLConfigurator
 * @create 2020-02-18 13:58
 */
public class XMLConfigurator implements Configurator {

    private final URL url;
    private final LoggerContext loggerContext;

    //====================================标签

    static final String APPENDER_TAG = "appender";
    static final String LOGGER_TAG = "logger";
    static final String CLASS_ATTR = "class";
    static final String NAME_ATTR = "name";
    static final String VALUE_ATTR = "value";
    static final String LEVEL_ATTR = "level";
    static final String FILTER_ATTR = "filter";
    static final String LAYOUT_TAG = "layout";
    static final String ENCODING_TAG = "encoding";
    static final String PARAM_TAG = "param";
    static final String ROOT_TAG = "root";
    static final String APPENDER_REF_TAG = "appender-ref";
    static final String APPENDER_REF_ATTR = "ref";

    private Map<String, Appender> appenderCache = Maps.newHashMap();

    public XMLConfigurator(URL url, LoggerContext loggerContext) {
        this.url = url;
        this.loggerContext = loggerContext;
    }

    @Override
    public void doConfigure() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(url.openStream());
            parse(document.getDocumentElement());
        } catch (ParserConfigurationException | IOException | SAXException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void parse(Element element) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        parseLoggers(element);
        parseRoot(element);
    }

    /**
     * 解析日志记录器
     * @param element
     */
    private void parseLoggers(Element element) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        NodeList loggerNodeList = element.getElementsByTagName(LOGGER_TAG);

        for (int i = 0; i < loggerNodeList.getLength(); i++) {
            DefaultLogger logger = parseChildrenOfLoggerElement(element);
            loggerContext.addLogger(logger);
        }
    }

    /**
     * 解析根日志记录器
     * @param element
     */
    private void parseRoot(Element element) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Element rootElement = getFirstElementByTagName(element, ROOT_TAG);

        DefaultLogger root = parseChildrenOfLoggerElement(rootElement);
        loggerContext.setRoot(root);
    }

    /**
     * 解析过滤器
     * @param filterNodeList
     * @return
     */
    private List<LogFilter> parseFilter(NodeList filterNodeList) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<LogFilter> filterList = Lists.newArrayList(filterNodeList.getLength());

        for (int i = 0; i < filterNodeList.getLength(); i++) {
            Element filterElement = (Element) filterNodeList.item(0);
            String filterClassName = filterElement.getAttribute(CLASS_ATTR);
            LogFilter filter = (LogFilter) Class.forName(filterClassName).newInstance();
            NodeList paramNodeList = filterElement.getElementsByTagName(PARAM_TAG);
            for (int j = 0; j < paramNodeList.getLength(); j++) {
                Element paramElement = (Element) paramNodeList.item(j);
                ReflectionUtils.setFieldValue(filter, paramElement.getAttribute(NAME_ATTR), paramElement.getAttribute(VALUE_ATTR));
            }
            filterList.add(filter);
        }
        return filterList;
    }

    /**
     * 解析布局
     * @param element
     * @return
     */
    private Layout parseLayout(Element element) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = element.getAttribute(CLASS_ATTR);
        Object instance = Class.forName(className).newInstance();
        Layout layout = (Layout) instance;

        NodeList params = element.getChildNodes();
        final int length = params.getLength();

        for (int loop = 0; loop < length; loop++) {
            Node currentNode = params.item(loop);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element currentElement = (Element) currentNode;
                String tagName = currentElement.getTagName();
                if (PARAM_TAG.equals(tagName)) {
                    String name = currentElement.getAttribute(NAME_ATTR);
                    String value = currentElement.getAttribute(VALUE_ATTR);
                    ReflectionUtils.setFieldValue(layout, name, value);
                }
            }
        }
        return layout;
    }

    /**
     * 根据日志节点解析子节点
     * @param element
     * @return
     */
    private DefaultLogger parseChildrenOfLoggerElement(Element element) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String name = element.getAttribute(NAME_ATTR);
        DefaultLogger logger = new DefaultLogger(name);
        String level = element.getAttribute(LEVEL_ATTR);
        if (!StringUtils.isBlank(level)) {
            logger.setLevel(Level.parse(level));
        }
        DefaultAppenderAttachable daa = new DefaultAppenderAttachable();
        logger.setAppenderAttachable(daa);

        NodeList appenderRefNodeList = element.getElementsByTagName(APPENDER_REF_TAG);
        int refLength = appenderRefNodeList.getLength();
        for (int i = 0; i < refLength; i++) {
            Element appenderRefNode = (Element) appenderRefNodeList.item(i);
            String appenderName = appenderRefNode.getAttribute(APPENDER_REF_ATTR);
            Appender appender = findAppenderByName(element.getOwnerDocument(), appenderName);
            daa.addAppender(appender);
        }
        return logger;
    }

    /**
     * 根据标签名称获取第一个节点
     * @param element
     * @param tagName
     * @return
     */
    private Element getFirstElementByTagName(Element element, String tagName) {
        NodeList elements = element.getElementsByTagName(tagName);
        if (elements.getLength() > 0) {
            return (Element) elements.item(0);
        }
        return null;
    }

    /**
     * 解析节点的编码
     * @param element
     * @return
     */
    private String parseEncoding(Element element) {
        return element.getNodeValue();
    }

    /**
     * 根据输出源名称查找输出源
     * @param document
     * @param appenderName
     * @return
     */
    private Appender findAppenderByName(Document document, String appenderName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Appender appender = appenderCache.get(appenderName);
        if (null != appender) {
            return appender;
        }
        NodeList appenderNodeList = document.getElementsByTagName(APPENDER_TAG);
        for (int i = 0, len = appenderNodeList.getLength(); i < len; i++) {
            Element appenderElement = (Element) appenderNodeList.item(i);
            String itemAppenderName = appenderElement.getAttribute(NAME_ATTR);

            if (appenderName.equals(itemAppenderName)) {
                String itemAppenderClassName = appenderElement.getAttribute(CLASS_ATTR);

                appender = (Appender) Class.forName(itemAppenderClassName).newInstance();
                appender.setName(itemAppenderName);

                Element layoutElement = getFirstElementByTagName(appenderElement, LAYOUT_TAG);
                Layout layout = parseLayout(layoutElement);
                ((AbstractAppender)appender).setLayout(layout);
                startComponent(layout);
                Element encodingElement = getFirstElementByTagName(appenderElement, ENCODING_TAG);
                if (null != encodingElement) {
                    String encoding = parseEncoding(encodingElement);
                    ((AbstractAppender) appender).setEncoding(encoding);
                }
                NodeList filterNodeList = appenderElement.getElementsByTagName(FILTER_ATTR);
                if (filterNodeList.getLength() > 0) {
                    List<LogFilter> filterList = parseFilter(filterNodeList);
                    ((AbstractAppender) appender).setFilterList(filterList);
                    for (LogFilter filter : filterList) {
                        startComponent(filter);
                    }
                }
                startComponent(appender);
                return appender;
            }
        }
        return null;
    }

    private void startComponent(LifeCycle component) {
        component.start();
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
