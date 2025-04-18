package functions

import (
	"database/sql"
	"fmt"
	"log"

	"os"

	"github.com/joho/godotenv"
	_ "github.com/lib/pq"
)

// Exported function to connect to PostgreSQL
func ConnectPostgres() (*sql.DB, error) {
	fmt.Println("Db started...\nTrying connection to db...")

	err := godotenv.Load(".env.local")
	if err != nil {
		log.Fatal("Error loading .env file:", err)
		return nil, err
	}

	connStr := fmt.Sprintf("host=%s port=%s user=%s password=%s dbname=%s sslmode=disable",
		os.Getenv("DB_HOST"), os.Getenv("DB_PORT"), os.Getenv("DB_USER"), os.Getenv("DB_PASSWORD"), os.Getenv("DB_NAME"))
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
