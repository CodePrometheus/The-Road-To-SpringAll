package aop;


import java.util.*;

public class Emp {
    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", tels=" + tels +
                ", addr=" + addr +
                ", email=" + Arrays.toString(email) +
                '}';
    }

    public Emp() {
        System.out.println("空参构造器");
    }


    public void setName(String name) {
        this.name = name;
        System.out.println("set方法name");
    }

    public void setId(String id) {
        this.id = id;
        System.out.println("set方法id");
    }

    private String name;
    private String id;
    private Set<String> tels;
    private List<String> addr;
    private Map<String, String> qqs;

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    private Properties prop;

    public Map<String, String> getQqs() {
        return qqs;
    }

    public void setQqs(Map<String, String> qqs) {
        this.qqs = qqs;
    }

    public List<String> getAddr() {
        return addr;
    }

    public void setAddr(List<String> addr) {
        this.addr = addr;
    }

    public Set<String> getTels() {
        return tels;
    }

    public void setTels(Set<String> tels) {
        this.tels = tels;
    }

    public String[] getEmail() {
        return email;
    }

    private String[] email;

    public void setEmail(String[] email) {
        this.email = email;
    }

}
