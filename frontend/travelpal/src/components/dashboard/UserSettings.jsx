import React, { useState } from "react";
import styles from "./UserSettings.module.css";

const UserSettings = () => {
  const [notificationsEnabled, setNotificationsEnabled] = useState(false);
  const [theme, setTheme] = useState("light");

  const notificationChangeHandler = () => {
    setNotificationsEnabled(!notificationsEnabled);
  };

  const themeChangeHandler = (event) => {
    setTheme(event.target.value);
  };

  const submitHandler = (event) => {
    event.preventDefault();
    alert(
      `Settings updated:\n- Notifications: ${
        notificationsEnabled ? "Enabled" : "Disabled"
      }\n- Theme: ${theme}`
    );
  };

  return (
    <div className={styles.greetingWrapper}>
      <h2 className={styles.heading}>User Settings</h2>{" "}
      <h3 style={{ color: "gray", opacity: 0.5 }}>
        (Work In Progress for Future Update)
      </h3>
      <div className={styles.settingsWrapper}>
        <form onSubmit={submitHandler} className={styles.settingsForm}>
          <section className={styles.settingSection}>
            <h3>Notifications</h3>
            <label className={styles.switch}>
              <input
                type="checkbox"
                checked={notificationsEnabled}
                onChange={notificationChangeHandler}
              />
              <span className={styles.slider}></span>
            </label>
          </section>
          <section className={styles.settingSection}>
            <h3>Theme</h3>
            <select
              value={theme}
              onChange={themeChangeHandler}
              className={styles.themeSelect}
            >
              <option value="light">Light</option>
              <option value="dark">Dark</option>
            </select>
          </section>
          <button type="submit" className={styles.btnSave}>
            Save Settings
          </button>
        </form>
      </div>
      <section className={styles.aboutSection}>
        <h3 className={styles.documentationHeader}>
          Want to read up on the Code Documentation?:
        </h3>
        <a
          href="https://benb0201.github.io/travelpal-code-documentation/classcom_1_1example_1_1travelpal_1_1models_1_1_itinerary.html"
          target="_blank"
          rel="noopener noreferrer" // for security reasons
          className={styles.docLink}
        >
          Link to the Backend Code Documentation webpage
        </a>
      </section>
      <section className={styles.aboutSection}>
        <h3 className={styles.documentationHeader}>Leave some Feedback:</h3>
        <a
          href="https://forms.gle/rk3NfUj6U5v1EHy5A"
          target="_blank"
          rel="noopener noreferrer" // for security reasons
          className={styles.docLink}
        >
          Link to TravelPal Survey :)
        </a>
      </section>
    </div>
  );
};

export default UserSettings;
