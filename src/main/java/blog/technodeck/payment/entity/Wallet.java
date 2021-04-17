package blog.technodeck.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Wallet extends PanacheEntity {
	
	@NotNull
	@Column(unique = true)
    public Long userId;
	@NotNull
    public Float balance;
	
	@NotBlank
	public String description;
	
}
