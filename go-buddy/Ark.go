package main

import (
	"fmt"
	"go-buddy/functions"
	"log"
)

func main() {
	db, err := functions.ConnectPostgres()
	if err != nil {
		log.Fatal("Error connecting to the database:", err)
	}
	defer db.Close()
	fmt.Println("Database connection closed.")
}
