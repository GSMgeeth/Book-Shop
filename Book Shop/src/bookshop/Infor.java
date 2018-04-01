package bookshop;

public class Infor {

    private boolean status;
    private String message;
    private Exception ex;
    private Object Other;

    public Infor(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Infor(boolean status, String message, Exception ex) {
        this.status = status;
        this.message = message;
        this.ex = ex;
    }

    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getOther() {
        return Other;
    }

    public void setOther(Object Other) {
        this.Other = Other;
    }

    
}
