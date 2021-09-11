package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.Hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private int candidateId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "birth_year")
	private String birthYear;
	
	@OneToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy ="candidate" )
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy ="candidate" )
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy ="candidate" )
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy ="candidate" )
	private List<SocialMediaAccount> socialMediaAccounts;
	
	@JsonIgnore
	@OneToMany(mappedBy ="candidate" )
	private List<Image> images;

}
