package kodlamaio.Hrms.entities.concretes;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="schools")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@NotNull
	@Column(name="is_graduate")
	private boolean isGraduate;
	
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
	@NotNull
	@Column(name="start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name="graduation_date")
	private Date graduationDate;
	
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;

}
