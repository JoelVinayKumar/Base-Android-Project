package com.example.prasanna.mytestproject;

public class Fields {
    String Name;
    String RollNo;
    String Spec;
    public Fields(String Name,String RollNo, String Spec){
        this.Name = Name;
        this.RollNo = RollNo;
        this.Spec = Spec;
    }

    public void setName(String title) {
        Name = title;
    }

    public String getName() {
        return "Name: "+Name;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getRollNo() {
        return "RollNo: "+RollNo;
    }
    public void setSpec(String description) {
        Spec = description;
    }

    public String getSpec() {
        return "Spec: "+Spec;
    }

    @Override
    public String toString() {
        return getName()+"\n"+getRollNo()+"\n"+getSpec();
    }
}
