package org.latamjugs.mastering.objetosmutables;

public final class Estudiante {
    //no debe tener SET
    private final int id;
    private String name;
    private final Age age;

    public Estudiante(int id, String name, Age age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public void setName(String newName){
        this.name = newName;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
