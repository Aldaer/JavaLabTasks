import java.util.Iterator;
import java.util.List;

public interface Range {
    boolean isBefore(Range otherRange);
    boolean isAfter(Range otherRange);
    boolean isConcurrent(Range otherRange);
    long getLowerBound();
    long getUpperBound();
    boolean contains(long value);
    List<Long> asList();
    Iterator<Long> asIterator();

    static Range newRange(long lb, long ub) {
        return new Range() {
            final long lowB = lb;
            final long uppB = ub;

            @Override
            public boolean isBefore(Range otherRange) {
                return false;
            }

            @Override
            public boolean isAfter(Range otherRange) {
                return false;
            }

            @Override
            public boolean isConcurrent(Range otherRange) {
                return false;
            }

            @Override
            public long getLowerBound() {
                return 0;
            }

            @Override
            public long getUpperBound() {
                return 0;
            }

            @Override
            public boolean contains(long value) {
                return false;
            }

            @Override
            public List<Long> asList() {
                return null;
            }

            @Override
            public Iterator<Long> asIterator() {
                return null;
            }
        };
    }
}
