package pl.mberkan.softwarecraftmanship.awsdemo;

public class Hello {
    private String hello;

    public Hello(String hello1) {
        this.hello = hello1;
    }

    public Hello() {
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
