class Config:
    """Configuration class that is shared between modules."""
    def __init__(self):
        self.row_count = 10
        self.input_file = ""
        self.output_file = ""

config = Config()