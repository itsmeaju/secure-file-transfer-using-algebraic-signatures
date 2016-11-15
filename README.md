# secure-file-transfer-using-algebraic-signatures
A secure way to access files in public cloud server

Here I've showed a way how transfer is done securely using 
client server implementation (based on java.net package)

##Client roles:
  1.Split a single file into many small files 
  2.Upload small files to Server1 
  3.Upload Large file to Server2
  
 
##Server1 roles:
  1.Receive small files from client 
  2.Append all files to form the large file
  3.Compute Signature(CRC 32) for the file
  
##Server2 roles:
  1.Receive large file from client 
  2.Compute Signature(CRC 32) for the file
 
####Check for validity and integrity of file by comparing signatures from Server1 and Server2  
#####After checking for validity, implementation can extend to allowing client to download files from server 
