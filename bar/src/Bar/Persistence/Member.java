package Bar.Persistence;

/**
 * Created by vinimtex on 12/09/2017.
 */
public class Member extends Customer{
    private int memberId;

    public Member(String cpf, String name, int age, char gender, int memberId) {
        super(cpf, name, age, gender);
        this.memberId = memberId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int id) {
        this.memberId = id;
    }
}
