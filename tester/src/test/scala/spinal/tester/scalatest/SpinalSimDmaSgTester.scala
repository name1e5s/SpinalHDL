package spinal.tester.scalatest

import org.scalatest.FunSuite
import spinal.core.HardType
import spinal.lib.bus.bmb.{Bmb, BmbParameter, BmbSlaveFactory}
import spinal.lib.bus.bmb.sim.{BmbDriver, BmbMemoryAgent}
import spinal.lib.system.dma.sg.{DmaSg, DmaSgTester, SgDmaTestsParameter}
import spinal.core.sim._

import scala.util.Random
import org.scalatest.{ParallelTestExecution, BeforeAndAfterAll, FunSuite}

class SpinalSimDmaSgTester extends FunSuite {
  Random.setSeed(42)
  for(testId <- 0 until 10){
    val p = SgDmaTestsParameter.random()
    test(s"random_$testId") {
      SgDmaTestsParameter.test(p)
    }
  }
  for((name, p) <- SgDmaTestsParameter(allowSmallerStreams = false)) test(name){
      SgDmaTestsParameter.test(p)
  }


}