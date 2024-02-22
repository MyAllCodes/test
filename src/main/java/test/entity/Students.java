package test.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Students {
@Id
private Long sapid;
@Column
private String firstName;
@Column
private String lastName;
@Column
private String emailId;
@Column
private String mobile;
}
