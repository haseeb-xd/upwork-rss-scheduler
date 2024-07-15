# Get Upwork Jobs in Mail  🚀

Welcome to my upwork job backend scheduler! Ever felt like other scheduling services were too expensive or didn't quite fit your needs? Well, fear not, because I've created this awesome backend to get upwork jobs before anyone else, get jobs in the mail the minute they are posted!



<p align="center">
  <img src="https://github.com/user-attachments/assets/3c43b902-95e5-4715-bbe9-e0ddb314b945" alt="schedule">
</p>


## Why Did I Create This?

Let's face it—applying quickly to Upwork jobs was always a challenge. Other scheduling tools were often pricey. I thought, "Why pay when I can create my own solution?" So, here it is—my very own backend scheduler. It's efficient, highly customizable, and best of all, it's free because I built it myself! 💪
## Features

- **Scheduled Task Execution**: Run tasks at regular intervals without breaking a sweat.
- **RSS Feed Integration**: Stay updated with the latest jobs on upwork before anyone else.
- **Upwork Job Notifications**: Automatically receive Upwork job notifications in your Gmail inbox.

## How to Use

1. **Clone the Repository**: Grab a copy of this repository to your local machine.

   ``` bash
   git clone https://github.com/haseeb-xd/upwork-rss-scheduler.git
    ```
   
2. **Set Application Properties**: Update the following properties in **application.properties**

    ``` properties
   # your email address
   spring.mail.username=${EMAIL_USERNAME} 
   # generate your app password from Google settings
   spring.mail.password=${APP_PASSWORD}
   # recipient email address, I used the same email address as the sender
   recipient.email=${RECIPIENT_EMAIL}
   # generate RSS feed URL from upwork account 
   upwork.rss.feed.url=${UPWORK_RSS_FEED_URL}
    ```
   
3. **Run the Application**: Execute the following command to run the application.

    ``` bash
    mvn spring-boot:run
    ```
4. **Sit Back and Relax**: The application will automatically fetch the latest jobs from the Upwork RSS feed and send them to your Gmail inbox.

## Contributing

If you have any suggestions or improvements, feel free to open an issue or create a pull request. I'd love to hear from you!

## Contact
Have questions or just want to say hi? Reach out to me at haseebansari1000@gmail.com.

Made with ❤️ by Haseeb Ansari






   
