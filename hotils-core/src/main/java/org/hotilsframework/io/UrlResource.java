package org.hotilsframework.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/24 00:02
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public boolean exists() throws ResourceException {
        return false;
    }

    @Override
    public URL getURL() throws IOException {
        return this.url;
    }

    @Override
    public URI getURI() throws IOException {
        try {
            return this.url.toURI();
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = this.url.openConnection();
        connection.connect();
        try {
            return connection.getInputStream();
        } catch (IOException e) {
            if (connection instanceof HttpURLConnection) {
                ((HttpURLConnection) connection).disconnect();
            }
            throw e;
        }
    }
}
