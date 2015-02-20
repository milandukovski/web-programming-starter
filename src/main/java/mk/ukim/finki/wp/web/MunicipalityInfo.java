package mk.ukim.finki.wp.web;

public class MunicipalityInfo{
    public String name;
    public String description;
    public String total;
   
    public void setName(String name) {this.name = name;}
    public void setdescription(String description) {this.description = description;}
    public void setTotal(String total) {this.total = total;}
   
    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getTotal(){return total;}
}