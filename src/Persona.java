class Persona {
    protected String nombre;
    protected String id;
    
    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
