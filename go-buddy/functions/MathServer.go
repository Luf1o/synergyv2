package functions

import (
	"fmt"
	"os"
	"strconv"
)

func StartMathServer() {
	fmt.Println("MathServer started...")
	if len(os.Args) != 4 {
		fmt.Println("Usage: go run MathServer.go <operation> <number>")
		return
	}

	op := os.Args[1]
	num1, err1 := strconv.ParseFloat(os.Args[2], 64)
	num2, err2 := strconv.ParseFloat(os.Args[3], 64)
	if err1 != nil || err2 != nil {
		fmt.Println("Error: Invalid number")
		return
	}
	switch op {
	case "+":
		fmt.Println(num1 + num2)
	case "-":
		fmt.Println(num1 - num2)
	case "*":
		fmt.Println(num1 * num2)
	case "/":
		if num2 == 0 {
			fmt.Println("Error: Division by zero")
			return
		}
		fmt.Println(num1 / num2)
	default:
		fmt.Println("Error: Invalid operation. Use 'square' or 'sqrt'")
		return
	}
}
