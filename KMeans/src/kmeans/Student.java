/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

/**
 *
 * @author truon
 */
public class Student {

    private String studentId;
    private String fullName;
    private double loc;
    private double mad;
    private double pro;
    private double prf;
    private double csi;

    public Student() {
    }

    public Student(String studentId, String fullName, double loc, double mad, double pro, double prf, double csi) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.loc = loc;
        this.mad = mad;
        this.pro = pro;
        this.prf = prf;
        this.csi = csi;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getLoc() {
        return loc;
    }

    public void setLoc(double loc) {
        this.loc = loc;
    }

    public double getMad() {
        return mad;
    }

    public void setMad(double mad) {
        this.mad = mad;
    }

    public double getPro() {
        return pro;
    }

    public void setPro(double pro) {
        this.pro = pro;
    }

    public double getPrf() {
        return prf;
    }

    public void setPrf(double prf) {
        this.prf = prf;
    }

    public double getCsi() {
        return csi;
    }

    public void setCsi(double csi) {
        this.csi = csi;
    }

}
