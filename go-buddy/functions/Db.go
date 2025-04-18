package functions

import (
	"database/sql"
	"fmt"
	"log"

	_ "github.com/lib/pq"
)

// Exported function to connect to PostgreSQL
func ConnectPostgres() (*sql.DB, error) {
	fmt.Println("Db started...\nTrying connection to db...")

	connStr := "host= port= user=leo password= dbname= sslmode=disable"
	db, err := sql.Open("postgres", connStr)
	if err != nil {
		log.Println("Error opening the database:", err)
		return nil, err
	}

	err = db.Ping()
	if err != nil {
		log.Println("Error pinging the database:", err)
		return nil, err
	}

	fmt.Println("✅ Connected to PostgreSQL successfully!")

	// Optional: check version
	var version string
	err = db.QueryRow("SELECT version()").Scan(&version)
	if err != nil {
		log.Println("Error querying version:", err)
		return nil, err
	}
	fmt.Println("PostgreSQL version:", version)

	return db, nil
}
