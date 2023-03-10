## Rest Server

### API Documentation
- ### Register 📃
  > POST /duplicate-strings
  #### Response 200 🟢
  ```
    {
      DupliicateWords Frequency
    }
  ```
  Example
    - > POST /duplicate-strings
      ``` 
       request.body = {
        {
          
       }
      ```
      **Response 200**
        ```
        {
            "how": 4,
            "no": 2,
            "are": 2,
            "try": 2,
             "ok": 2
        }
        ```
