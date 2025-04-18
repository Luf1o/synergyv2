import sys


def main():
    print("Executing python script")
    if len(sys.argv) > 1:
        try:
            num = float(sys.argv[1])
            print(num ** 2)
            
        except Exception as e:
            print(f"There seems to be an error {e}")
    else:
        print('No input recieved')
    
if __name__ == "__main__":
    main()