package br.com.caelum.calopsita.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.CollectionOfElements;

@Entity
public class CardType {

	@Id
	private Long id;

	private String name;

	@CollectionOfElements
	@Enumerated(EnumType.STRING)
	private List<Gadgets> gadgets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Gadgets> getGadgets() {
		return gadgets;
	}

	public void setGadgets(List<Gadgets> gadgets) {
		this.gadgets = gadgets;
	}

}