import com.epam.botor.domain.Army
import com.epam.botor.domain.Trooper

import static ClassLoader.getSystemResourceAsStream



beans {
	xmlns(context:'http://www.springframework.org/schema/context')

	context.'component-scan'('base-package':"com.epam.botor.config")
	
	def trooperSluper = new XmlSlurper().parse(getSystemResourceAsStream("troopers.xml"))
	def i = 0
	trooperSluper.trooper.each {
		"trooper${++i}"(Trooper, it.@name.text(), it.@gender.text()) 
	}

	armyOfLight5(Army) {
		leader = ref('anakin')

		def troopers = []
		(1..i).each {
			troopers.add(ref('trooper' + it))
		}
		
		fighters = troopers
	}	
}

