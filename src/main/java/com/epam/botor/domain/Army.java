package com.epam.botor.domain;

import java.util.Set;

public class Army {

    private Person leader;
    private Set<Person> fighters;

    
    public Army(final Person leader, final Set<Person> fighters) {
        super();
        this.leader = leader;
        this.fighters = fighters;
    }

    public Army() {
        super();
    }
    
    public Person getLeader() {
        return leader;
    }

    public Set<Person> getFighters() {
        return fighters;
    }

    
	public void setLeader(Person leader) {
		this.leader = leader;
	}
	public void setFighters(Set<Person> fighters) {
		this.fighters = fighters;
	}
	@Override
	public String toString() {
		return "Army [leader=" + leader + ", fighters=" + fighters + "]";
	}

    
}
