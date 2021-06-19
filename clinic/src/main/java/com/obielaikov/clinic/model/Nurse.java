package com.obielaikov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
public class Nurse extends MedicalStaff {

    @ManyToMany
    @JoinTable(
            name = "nurse_certification",
            joinColumns = {@JoinColumn(name = "nurse_id", foreignKey = @ForeignKey(name = "fk_certification_nurse"))},
            inverseJoinColumns = {@JoinColumn(name = "certification_id", foreignKey = @ForeignKey(name = "fk_nurse_certification"))}
    )
    @Size(min = 1)
    private Set<Certification> certifications;
}
