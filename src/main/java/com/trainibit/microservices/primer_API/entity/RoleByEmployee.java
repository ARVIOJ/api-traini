package com.trainibit.microservices.primer_API.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "role_by_employee")
public class RoleByEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_by_employee_id_gen")
    @SequenceGenerator(name = "role_by_employee_id_gen", sequenceName = "role_by_employee_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_role_id", nullable = false)
    private Role role;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date", nullable = false)
    private LocalDate updatedDate;

    @ColumnDefault("true")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee fkEmployee) {
        this.employee = fkEmployee;
    }

    public Role getRole() {
        return role;
    }

    //public void setRole(List<Role> rol) {
    public void setRole(Role rol) {
        //this.role = fkRole;
        this.role = rol;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}