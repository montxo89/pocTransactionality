## Microservice Poc Sample

The project is composed by the following elements:
- Orchestrator: Which receives the communication, API exposed in swagger.
- Transactionality: Contains a supposed security validator which returns a tokens, mocked right now.
- Three micros which access to databases 1-1, the database is H2, the url is in the properties hardcoded.
