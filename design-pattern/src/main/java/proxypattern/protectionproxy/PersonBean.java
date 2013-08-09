package proxypattern.protectionproxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/1/13
 */
public interface PersonBean {
    String getName();

    String getGender();

    String getInterests();

    int getHotOrNotRating();

    void setName(String name);

    void setGender(String gender);

    void setInterests(String interests);

    void setHotOrNotRating(int rating);
}
