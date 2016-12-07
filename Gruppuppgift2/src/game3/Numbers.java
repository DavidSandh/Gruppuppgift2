package game3;
/**
 * Klassen Number utför beräkningen av timer
 * @author Rolf Axelsson
 *
 */
public class Numbers {
	private int mStartValue;
	private int mChange;
	private int mValues;
	private int mCount;
	private int mCurrentValue;
	
	public Numbers(int startValue, int values, int change) {
		mCurrentValue = mStartValue = startValue;
		mValues = values;
		mChange = change;
	}
	
	private void init() {
		mCount = 0;
	}
	
	public int nextValue() {
		if(mCount<mValues) {
			mCurrentValue += mChange;
			mCount++;
		} else {
			mCount=0;
			mCurrentValue = mStartValue;
		}
		return mCurrentValue;
	}
	
	public int currentValue() {
		return mCurrentValue;
	}
}
