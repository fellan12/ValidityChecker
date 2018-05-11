package omegapoint.data;

public class CandidateData<T> {

    private T data;

    public CandidateData(T content) {
	this.data = content;
    }

    public T getContent() {
	return this.data;
    }
}
