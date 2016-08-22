import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RangeTestClass {
    final Range R1;
    final Range R2;
    final RangeTestParams params;

    @AllArgsConstructor
    private static class RangeTestParams {
        final long lb1;
        final long ub1;
        final long lb2;
        final long ub2;
        final long n;
        final boolean before;
        final boolean after;
        final boolean concurrent;
        final boolean nIn1;
    }

    @Parameterized.Parameters
    public static Collection<RangeTestParams> testData() {
        RangeTestParams rp1 = new RangeTestParams(0, 100, 200, 300, 50, true, false, false, true);
        RangeTestParams rp2 = new RangeTestParams(0, 100, 300, 200, 250, true, false, false, false);
        RangeTestParams rp3 = new RangeTestParams(0, 100, 90, 110, 100, false, false, true, true);
        RangeTestParams rp4 = new RangeTestParams(100, 0, -200, -110, 0, false, true, false, true);
        RangeTestParams[] ranges = { rp1, rp2, rp3, rp4 };
        return Arrays.asList(ranges);
    }

    public RangeTestClass(RangeTestParams params) {
        this.params = params;
        R1 = Range.newRange(params.lb1, params.ub1);
        R2 = Range.newRange(params.lb2, params.ub2);
    }


    @Test
    public void name() throws Exception {

    }
}
