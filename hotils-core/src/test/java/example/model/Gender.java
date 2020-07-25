package example.model;

/**
 * @author hireny
 * @className Gender
 * @create 2020-07-07 7:00
 */
public enum Gender {

    Male("男人"),
    Female("女人"),
    Unknown("保密");


    private String value;

    Gender(String s) {
        this.value = s;
    }
}
