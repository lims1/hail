package org.broadinstitute.hail.utils

import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test

import org.broadinstitute.hail.Utils._

class UtilsSuite extends TestNGSuite {
  @Test def testD_==() {
    assert(D_==(1, 1))
    assert(D_==(1, 1 + 1E-7))
    assert(!D_==(1, 1 + 1E-5))
    assert(D_==(1E10, 1E10 + 1))
    assert(!D_==(1E-10, 2E-10))
    assert(D_==(0.0, 0.0))
    assert(D_!=(1E-307, 0.0))
    assert(D_==(1E-308, 0.0))
    assert(D_==(1E-320, -1E-320))
  }

  @Test def testFlushDouble() {
    assert(flushDouble(8.0E-308) == 8.0E-308)
    assert(flushDouble(-8.0E-308) == -8.0E-308)
    assert(flushDouble(8.0E-309) == 0.0)
    assert(flushDouble(-8.0E-309) == 0.0)
    assert(flushDouble(0.0) == 0.0)
  }
}