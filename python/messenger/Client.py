import subprocess
import logging

logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s %(message)s ',
    filename='app.log'
)

logger = logging.getLogger(__name__)

def call_java_func(number,mode):
    try:
        # ["java", "path",mode,str(number)]  <- message ,path: location of java file
        result = subprocess.run(["java","../java-interface/functions/MathServer.java",mode,str(number)],capture_output=True,text=True)
        print(f"Java Response: {result.stdout.strip()}")
        if result.stderr:
            print("Error Recieving output")
    except Exception as er:
        print(f"Error Occurred {er}")
        
        
def call_go_math_server(number1,number2,mode):
    try:
       result = subprocess.run(["go","run","../go-buddy/functions/MathServer.go",mode,str(number1),str(number2)], capture_output=True,text=True)
       if result.returncode == 0:
           print(f"go Response: {result.stdout.strip()}")
       else:
           logger.debug(f'Error recieveing {result.stderr.strip()}')
    except Exception as er:
        logger.debug("Unknown Error")
        logger.info(er)
        logger.warning("Warning message")


def main():
    number,mode = int(input("Enter a number: ")),input("Select Either Square / SquareRoot :")
    num1 , num2 ,mode2 = int(input("Enter number 1: ")),int(input("Enter number 2")),input("Select (+,-,*,/) : ")
    call_java_func(number=number,mode=mode)
    call_go_math_server(num1,num2,mode2)

    
if __name__ == "__main__":
    main()