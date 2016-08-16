package com.epam.botor.domain;

import java.util.Set;

public class Army {

    private final Person leader;
    private final Set<Person> fighters;

    public Army(final Person leader, final Set<Person> fighters) {
        super();
        this.leader = leader;
        this.fighters = fighters;
    }

    public Person getLeader() {
        return leader;
    }

    public Set<Person> getFighters() {
        return fighters;
    }

	@Override
	public String toString() {
		return "Army [leader=" + leader + ", fighters=" + fighters + "]";
	}

    
}
