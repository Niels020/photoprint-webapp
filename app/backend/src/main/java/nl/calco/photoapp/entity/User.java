package nl.calco.photoapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message =  "username cannot be blank")
    @Size(min = 6, max = 30, message = "username is too short or long")
	@NonNull
	@Column(nullable = false, unique = true)
	private String username;

	@NotBlank(message =  "password cannot be blank")
    @Size(min = 10, max = 30, message = "password is too short or long")
    @NonNull
	@Column(nullable = false)
	private String password;

}
