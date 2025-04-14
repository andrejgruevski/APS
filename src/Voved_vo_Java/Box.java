package Voved_vo_Java;

public class Box<T> {
    private T objekt;
    public Box(){

    }
    Box(T objekt){
        this.objekt = objekt;
    }

    public T getObjekt() {
        return objekt;
    }

    public void setObjekt(T objekt) {
        this.objekt = objekt;
    }

    @Override
    public String toString() {
        return "Kutijata sodrzhi objekt: " + objekt;
    }
}
