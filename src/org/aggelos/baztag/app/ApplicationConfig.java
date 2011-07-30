package org.aggelos.baztag.app;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.aggelos.baztag.model.PNabaztag;
import org.aggelos.baztag.model.Thing;

import com.google.appengine.api.datastore.Key;

/**
 * An application config will describe for a given {@link PNabaztag} what to perform
 * @author aggelos
 *
 */

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUBCLASS_TABLE)
public abstract class ApplicationConfig {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    protected Key key;
	
	// a config is associated to a PNabaztag
	@Persistent 
	protected Thing thing;
	
	@Persistent
	protected int frequency;
	
	@Persistent
	protected String voice;
	
	public abstract String getApplicationIdentifier();
	
		/*NabaztagInstructionSequence seq = new NabaztagInstructionSequence();
	/*public void say(String text) {
		NabaztagInstructionSequence seq = new NabaztagInstructionSequence();
		VoiceInstruction vi = new VoiceInstruction(voice);
		TextInstruction ti = new TextInstruction(text);
		seq.add(ti);
		seq.add(vi);
	}*/

	public Thing getThing() {
		return thing;
	}

	public void setThing(Thing nabaztag) {
		this.thing = nabaztag;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}
	
	
	
}
