package supermarket;

public class SellerManager implements Supermarket{
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    private String Id, Name, SPassword, SGender;

    public String getId() {
        return Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
    public String getSPassword() {
        return SPassword;
    }
    public void setSPassword(String SPassword) {
        this.SPassword = SPassword;
    }
    public String getSGender() {
        return SGender;
    }
    public void setSGender(String SGender) {
        this.SGender = SGender;
    }
}
