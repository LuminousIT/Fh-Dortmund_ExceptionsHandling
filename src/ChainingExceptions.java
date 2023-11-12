class NoLeaveGrantedException extends Exception {
	public NoLeaveGrantedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLeaveGrantedException(String message) {
        super(message);
    }
}

class TeamLeadUpsetException extends Exception {
	public TeamLeadUpsetException(String message) {
		super(message);
	}
}