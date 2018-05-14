package omegapoint.data;

import java.util.*;

public class CandidateData<T> {

    private T data;
    private UUID id;

    public CandidateData(T content) {
	this.id = UUID.randomUUID ();
	this.data = content;
    }
    
    public UUID getId() {
	return id;
    }

    public T getContent() {
	return this.data;
    }
}
