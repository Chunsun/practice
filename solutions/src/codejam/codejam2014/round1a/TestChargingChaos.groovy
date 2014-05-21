package codejam.codejam2014.round1a

import org.junit.*;

class TestChargingChaos {
	ChargingChaos chargingChaos
	@Before
	void setUp() {
		chargingChaos = new ChargingChaos('small')
	}
	
	@Test
	void getInput() {
		assert chargingChaos.getInput() != null
	}
	
	@Test
	void setTotalCases() {
		chargingChaos.setTotalCases()
		assert chargingChaos.getTotalCases() > 0
	}
	
	void setFirstCaseParameter() {
		chargingChaos.setTotalCases()
		chargingChaos.setCaseData()
		chargingChaos.setSrcFlows()
		chargingChaos.setReqFlows()
	}
	
	@Test
	void testFirstCaseParameters() {
		setFirstCaseParameter()
		
		assert chargingChaos.getTotalCases() > 0
		assert chargingChaos.getDeviceCount() > 0
		assert chargingChaos.getFlowLength() > 0
		assert chargingChaos.getSrcFlows().length > 0
		assert chargingChaos.getReqFlows().length > 0
	}
	
	@Test 
	void testCompare() {
		def input_1 = '000111000100101101101'
		def input_2 = '111010000001000011010'
		def flowLength = 21
		chargingChaos.setFlowLength(flowLength)
		def result = chargingChaos.compare(input_1, input_2)
		assert result != null
	}

	@Test
	void testSolveSmall() {
		chargingChaos.solve('small-result')
	}
	
	@Test 
	void testSolveLarge() {
		chargingChaos = new ChargingChaos('large')
		chargingChaos.solve('large-result')
	}
}
