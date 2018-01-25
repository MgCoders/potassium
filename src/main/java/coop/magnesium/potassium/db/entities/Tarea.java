package coop.magnesium.potassium.db.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pablo on 21/01/18.
 */
@Entity
@JsonAutoDetect
@ApiModel
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @Column(name = "minutos_estimados")
    private Integer minutosEstimados;

    private Integer borrada;

    @OneToMany(mappedBy = "tarea", fetch = FetchType.EAGER)
    private Set<Registro> registros = new HashSet<>();

    @OneToMany(mappedBy = "tarea", fetch = FetchType.EAGER)
    private Set<TareaMaterial> tareaMateriales = new HashSet<>();


    public Tarea() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getMinutosEstimados() {
        return minutosEstimados;
    }

    public void setMinutosEstimados(Integer minutosEstimados) {
        this.minutosEstimados = minutosEstimados;
    }

    public Integer getBorrada() {
        return borrada;
    }

    public void setBorrada(Integer borrada) {
        this.borrada = borrada;
    }

    public Set<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Set<Registro> registros) {
        this.registros = registros;
    }

    public Set<TareaMaterial> getTareaMateriales() {
        return tareaMateriales;
    }

    public void setTareaMateriales(Set<TareaMaterial> tareaMateriales) {
        this.tareaMateriales = tareaMateriales;
    }
}
