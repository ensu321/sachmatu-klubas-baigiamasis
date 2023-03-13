import { savePlayer } from "../../../Commons/requests.js";

//function handles from submit and creates the object of the player with the values from the form
const handleFormSubmit = async () => {
  const form = document.getElementById("addPlayerForm").querySelector("form");
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const player = {
      email: form.playerEmail.value,
      firstName: form.playerName.value,
      lastName: form.playerSurname.value,
      personalCode: form.playerPersonalCode.value,
      startDate: form.playerStartDate.value,
    };
    await savePlayer(player);
    window.location.reload();
  });
};

//handles cancel button action/event listiner
const handleCancelButton = () => {
  document.getElementById("cancelButton").addEventListener("click", () => {
    window.location.replace("../list-players/list-players.html");
  });
};

// self-invoking async function in JavaScript. It is immediately invoked when the code is executed, and it runs asynchronously due to the async keyword.
(async () => {
  handleCancelButton();
  await handleFormSubmit();
})();
