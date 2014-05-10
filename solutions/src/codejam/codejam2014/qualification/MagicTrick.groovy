package codejam.codejam2014.qualification

import java.util.Scanner;

class MagicTrick {
	def final BAD = 'Bad magician!'
	def final CHEAT = 'Volunteer cheated!'
	
	def file
	def input
	def scanner
	def totalTimes
	def time = 0
	def answer
	def row
	def result
	def output = []
	
	void setInput() {
		file = new File('./src/codejam/codejam2014/qualification/A-small-practice.in')
		input = file.text
	}
	
	void setScanner() {
		scanner = new Scanner(input)
	}
	
	void setTotalTimes() {
		totalTimes = scanner.nextLine().toInteger()
	}
	
	void setAnswer() {
		answer = scanner.nextLine().toInteger()
	}
	
	def getRow() {
		def cacheRow
		for (int i = 0; i < 4; i++) {
			cacheRow = scanner.nextLine()
			if (i + 1 == answer) {
				row = cacheRow
			}
		}
		return toArray(row)
	}
	
	def toArray(def row) {
		return row.split(' ')
	}
	
	def checkAnswers(def firstAns, def secondAns) {
		time++
		def number = 0
		def hit = 0
		for (int i = 0; i < 4; i++) {
			number = firstAns[i]
			if (secondAns.contains(number)) {
				result = number
				hit++
			}
		}
		if (hit == 0) {
			result = CHEAT
		} else if (hit > 1) {
			result = BAD
		}
		return result
	}
	
	def printResult() {
		def magicResult = 'Case #' + time + ': ' + result 
		println magicResult
		output << magicResult
	}
	
	def startNewMagic() {
		setAnswer()
		def firstRound = getRow()
		setAnswer()
		def secondRound = getRow()
		
		checkAnswers(firstRound, secondRound)
		printResult()
	}
	
	def writeOutputResult() {
		def resultFile = new File('./src/codejam/codejam2014/qualification/magic-result.txt')
		if (resultFile.exists()) {
			resultFile.delete()
		}
		
		resultFile.withWriter{ out ->
			output.each {
				out.println it
			}
		}
	}
	
	def startMagicTrick() {
		setScanner()
		setTotalTimes()
		for (int i = 0; i < totalTimes; i++) {
			startNewMagic()
		}
	}
	
}
