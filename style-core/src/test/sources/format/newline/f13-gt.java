class Main {
	@SuppressWarnings("unchecked")
	@PostMapping(consumes = "multipart/form-data", value = "/repair")
	public void remove(PublishSubscription<T> ps) {}

	@SuppressWarnings("unchecked") 
	@PostMapping(consumes = "multipart/form-data", value = "/repair")
	void remove(PublishSubscription<T> ps) {}

	@SuppressWarnings("unchecked")
	public void remove(PublishSubscription<T> ps) {}

	@SuppressWarnings("unchecked") 
	public void remove(PublishSubscription<T> ps) {}
}
