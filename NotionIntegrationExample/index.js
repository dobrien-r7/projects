import { Client } from "@notionhq/client"

const notion = new Client({ auth: process.env.secret_t3w5cJ0mIKcOVEdLt6h8m39Z8SsTBPIAUifUUz7LJGb })

const databaseId = process.env.Playing-With-Integrations-cc390089e7d94869ab0e07f0b9606d87

async function addItem(text) {
  try {
    const response = await notion.pages.create({
      parent: { database_id: databaseId },
      properties: {
        title: { 
          title:[
            {
              "text": {
                "content": text
              }
            }
          ]
        }
      },
    })
    console.log(response)
    console.log("Success! Entry added.")
  } catch (error) {
    console.error(error.body)
  }
}

addItem("An excellent coder am I, yes")