package codejam.codejam2014.round1a

class ChargingChaos {
	def final SMALL_PROB = 'A-small-practice.in'
	def final LARGE_PROB = 'A-large-practice.in'
	
	def final CASE = 'Case #'
	def final COLON = ': '
	def final FAIL = 'NOT POSSIBLE'
	
	def input
	def scanner
	def totalCases
	def caseCount
	def deviceCount
	def flowLength
	def srcFlows
	def reqFlows
	def diffCount
	def result
	def answer
	def output
	def candidateDiff
	
	ChargingChaos(def prob) {
		caseCount = 1
		diffCount = []
		output = []
		candidateDiff = []
		setInput(prob)
		setScanner()
	}
	
	void setInput(def prob) {
		def fileName = ''
		if (prob.equals('small')) {
			fileName = SMALL_PROB
		} else if (prob.equals('large')) {
			fileName = LARGE_PROB
		}
		
		def file = new File('./src/codejam/codejam2014/round1a/' + fileName)
		input = file.text
	}
	
	void setScanner() {
		scanner = new Scanner(input)
	}
	
	void setTotalCases() {
		totalCases = scanner.nextLine().toInteger()
	}
	
	void setCaseData() {
		def caseData = scanner.nextLine().split(' ')
		deviceCount = caseData[0].toInteger()
		flowLength = caseData[1].toInteger()
	}
	
	void setSrcFlows() {
		srcFlows = scanner.nextLine().split(' ')
	}
	
	void setReqFlows() {
		reqFlows = scanner.nextLine().split(' ')
	}
	
	def compare(def srcFlow, def reqFlow) {
		return Long.parseLong(srcFlow, 2) ^ Long.parseLong(reqFlow, 2)
	}
	
	void recordDiffCount() {
		for (diff in candidateDiff) {
			diffCount.push(Long.bitCount(diff))
		}
	}
	
	void checkDiff() {
		def currentDiff = []
		def srcFlow
		for (int index = 0; index < srcFlows.length; index++) {
			srcFlow = srcFlows[index]
			
			if (candidateDiff.size() != 0 || index == 0) {
				for (reqFlow in reqFlows) {
					def resultDiff = compare(srcFlow, reqFlow) 
					if (resultDiff in candidateDiff || index == 0) {
						currentDiff.push(resultDiff)
					}
				}
			} else {
				candidateDiff = currentDiff
				result = false
				break
			}
			candidateDiff = currentDiff
			currentDiff = []
			result = true
		}
	}
	
	def recordAnswer() {
		def count
		if (diffCount.size() > 0) {
			count = GroovyCollections.min(diffCount)
		} else {
			result = false
		}
		
		if (result) {
			answer = CASE + caseCount + COLON + count 
		} else {
			answer = CASE + caseCount + COLON  + FAIL
		}
		output << answer
	}
	
	def writeOutputFile(def fileName) {
		def path = './src/codejam/codejam2014/round1A/' + fileName
		def resultFile = new File(path)
		if (resultFile.exists()) {
			resultFile.delete()
		}
		
		resultFile.withWriter{ out ->
			output.each {
				out.println it
			}
		}
	}
	
	def startCaseLoop() {
		for (i in 1..totalCases) {
			setCaseData()
			setSrcFlows()
			setReqFlows()
			checkDiff()
			recordDiffCount()
			recordAnswer()
			diffCount = []
			caseCount++
		}
	}
	
	def solve(def problem) {
		setTotalCases()
		startCaseLoop()
		writeOutputFile(problem)
	}
}
